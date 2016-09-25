/**
 * Created by pkochetk on 9/24/16.
 */


var map;
var markers = [];

function initMap() {
    //37.3229621,-121.982301

    var locations = [
        ['Bondi Beach', -33.890542, 151.274856, 4],
        ['Coogee Beach', -33.923036, 151.259052, 5],
        ['Cronulla Beach', -34.028249, 151.157507, 3],
        ['Manly Beach', -33.80010128657071, 151.28747820854187, 2],
        ['Maroubra Beach', -33.950198, 151.259302, 1]
    ];

    var description =
        ['<div class="info_content">' +
        '<h3>London Eye</h3>' +
        '<p>The London Eye is a giant Ferris wheel situated on the banks of the River Thames. The entire structure is 135 metres (443 ft) tall and the wheel has a diameter of 120 metres (394 ft).</p>' +
        '<button style="color: red">PickUp</button>',

            '<div class="info_content"><h3>London Eye</h3><p>The London Eye is a giant Ferris wheel situated on the banks of the River Thames. The entire structure is 135 metres (443 ft) tall and the wheel has a diameter of 120 metres (394 ft).</p></div>',
            '<div class="info_content"><h3>London Eye</h3><p>The London Eye is a giant Ferris wheel situated on the banks of the River Thames. The entire structure is 135 metres (443 ft) tall and the wheel has a diameter of 120 metres (394 ft).</p></div>',
            '<div class="info_content"><h3>London Eye</h3><p>The London Eye is a giant Ferris wheel situated on the banks of the River Thames. The entire structure is 135 metres (443 ft) tall and the wheel has a diameter of 120 metres (394 ft).</p></div>',
            '<div class="info_content"><h3>London Eye</h3><p>The London Eye is a giant Ferris wheel situated on the banks of the River Thames. The entire structure is 135 metres (443 ft) tall and the wheel has a diameter of 120 metres (394 ft).</p></div>'];

    var center_lon = 0;
    var center_lat = 0;


    for (var i = 0; i < locations.length; i++) {
        center_lat += locations[i][1];
        center_lon += locations[i][2];
    }
    center_lat /= locations.length;
    center_lon /= locations.length

    map = new google.maps.Map(document.getElementById('map'), {
        center: new google.maps.LatLng(center_lat, center_lon),
        zoom: 11,
    });

    var infowindow = new google.maps.InfoWindow();

    for (var i = 0; i < locations.length; i++) {
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
            map: map,
            animation: google.maps.Animation.DROP,
            title: 'Hello World!'
        });

        markers.push(marker);

        google.maps.event.addListener(marker, 'click', (function (marker, i) {
            return function () {
                infowindow.setContent(description[i]);
                infowindow.open(map, marker);
            }
        })(marker, i));
    }
    
}


function toggleBounce() {
    if (marker.getAnimation() !== null) {
        marker.setAnimation(null);
    } else {
        marker.setAnimation(google.maps.Animation.BOUNCE);
    }
}


function clearMarkers() {
    console.log(markers);
    for (var i=0; i<markers.length; i++) {
        markers[i].setMap(null);
    }
}

$(".general_menu_a").click(function()  {
    clearMarkers();
    $(".general_menu_tabs").removeClass("active");
    $(this).addClass("active");
});