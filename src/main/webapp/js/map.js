/**
 * Created by pkochetk on 9/24/16.
 */


var map;
var markers = [];
var description = [];
var infowindow;
var CURRENT_DATA;

function initMap() {
    //37.3229621,-121.982301


    var locations = [
        ['Bondi Beach', -33.890542, 151.274856, 4],
        ['Coogee Beach', -33.923036, 151.259052, 5],
        ['Cronulla Beach', -34.028249, 151.157507, 3],
        ['Manly Beach', -33.80010128657071, 151.28747820854187, 2],
        ['Maroubra Beach', -33.950198, 151.259302, 1]
    ];


    /*
    var description =
        ['<div class="info_content">' +
        '<h3>London Eye</h3>' +
        '<p>The London Eye is a giant Ferris wheel situated on the banks of the River Thames. The entire structure is 135 metres (443 ft) tall and the wheel has a diameter of 120 metres (394 ft).</p>' +
        '<button style="color: red">PickUp</button>',

            '<div class="info_content"><h3>London Eye</h3><p>The London Eye is a giant Ferris wheel situated on the banks of the River Thames. The entire structure is 135 metres (443 ft) tall and the wheel has a diameter of 120 metres (394 ft).</p></div>',
            '<div class="info_content"><h3>London Eye</h3><p>The London Eye is a giant Ferris wheel situated on the banks of the River Thames. The entire structure is 135 metres (443 ft) tall and the wheel has a diameter of 120 metres (394 ft).</p></div>',
            '<div class="info_content"><h3>London Eye</h3><p>The London Eye is a giant Ferris wheel situated on the banks of the River Thames. The entire structure is 135 metres (443 ft) tall and the wheel has a diameter of 120 metres (394 ft).</p></div>',
            '<div class="info_content"><h3>London Eye</h3><p>The London Eye is a giant Ferris wheel situated on the banks of the River Thames. The entire structure is 135 metres (443 ft) tall and the wheel has a diameter of 120 metres (394 ft).</p></div>'];
    */
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
        zoom: 10,
    });

    infowindow = new google.maps.InfoWindow();

    for (var i = 0; i < locations.length; i++) {
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
            map: map,
            animation: google.maps.Animation.DROP,
            title: 'Hello World!'
        });

        markers.push(marker);

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
    for (var i=0; i<markers.length; i++) {
        markers[i].setMap(null);
    }
}

function updateMap() {
    updateMarkers();
}

function updateMarkers() {
    markers = [];
    descriptions = [];
    var center_lon = 0;
    var center_lat = 0;

    for (var i=0; i<CURRENT_DATA.length; i++) {
        console.log(CURRENT_DATA[i]['lat'], CURRENT_DATA[i]['lon']);
        center_lat += CURRENT_DATA[i]['lat'];
        center_lon += CURRENT_DATA[i]['lon'];
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(CURRENT_DATA[i]['lat'], CURRENT_DATA[i]['lon']),
            map: map,
            animation: google.maps.Animation.DROP,
            title: 'Hello World!'
        });

        infowindow = new google.maps.InfoWindow();
        markers.push(marker)
        descriptions.push(generateDescription(CURRENT_DATA[i]["name"], CURRENT_DATA[i]["address"], CURRENT_DATA[i]["phone"]));

        marker.addListener('click', (function (marker, i) {
            return function () {
                infowindow.setContent(descriptions[i])
                infowindow.open(map, marker);
            }
        })(marker, i));

        marker.setMap(map);
    }
    center_lat /= CURRENT_DATA.length;
    center_lon /= CURRENT_DATA.length;
    map.setCenter(new google.maps.LatLng(center_lat, center_lon));

}

$(".general_menu_a").click(function()  {
    clearMarkers();
    $(".general_menu_tabs").removeClass("active");
    $(this).addClass("active");
    $(".svg").css("fill", "#c7eaf9");
    $(this).find(".svg").css("fill", "#ee635d");
    var good_type = $(this).attr("good_type");
    for (var i=0; i<data.length; i++) {
        var type = Object.getOwnPropertyNames(data[i])[0];
        if (type==good_type) {
            CURRENT_DATA = data[i][type];
        }
    }
    updateMap();
});

$(".type_item_a").click(function () {
    setTimeout(function () {
        var id = location.hash.slice(1);
        id = parseInt(id);
        infowindow.setContent(descriptions[id])
        infowindow.open(map, markers[id]);
    }, 100);
});
setTimeout(function () {

    $(".general_menu_a")[0].click();
    $(".general_menu_tabs")[0].click();
    CURRENT_DATA = data[0];
}, 100);


jQuery('img.svg').each(function(){
    var $img = jQuery(this);
    var imgID = $img.attr('id');
    var imgClass = $img.attr('class');
    var imgURL = $img.attr('src');

    jQuery.get(imgURL, function(data) {
        // Get the SVG tag, ignore the rest
        var $svg = jQuery(data).find('svg');

        // Add replaced image's ID to the new SVG
        if(typeof imgID !== 'undefined') {
            $svg = $svg.attr('id', imgID);
        }
        // Add replaced image's classes to the new SVG
        if(typeof imgClass !== 'undefined') {
            $svg = $svg.attr('class', imgClass+' replaced-svg');
        }

        // Remove any invalid XML tags as per http://validator.w3.org
        $svg = $svg.removeAttr('xmlns:a');

        // Check if the viewport is set, if the viewport is not set the SVG wont't scale.
        if(!$svg.attr('viewBox') && $svg.attr('height') && $svg.attr('width')) {
            $svg.attr('viewBox', '0 0 ' + $svg.attr('height') + ' ' + $svg.attr('width'))
        }

        // Replace image with new SVG
        $img.replaceWith($svg);

    }, 'xml');

});

