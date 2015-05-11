<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--  <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>--%>

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyAbkciXgFbZK-LCpARrhC1_DzsMCoUnmEI&libraries=places"></script>
	  <style>
       <style>
      html, body, #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
      #panel {
        position: absolute;
        top: 5px;
        left: 50%;
        margin-left: -180px;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
      }
	  </style>
	<style>
	html, body, #map {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
	</style>
	
<script>
	window.onload = getMyLocation;
var geocoder;

var map;
function getMyLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(displayLocation);
  } else {
    alert("Oops, no geolocation support");
  }
}

//This function is inokved asynchronously by the HTML5 geolocation API.
function displayLocation(position) {
  //The latitude and longitude values obtained from HTML 5 API.
  var latitude = position.coords.latitude;
  var longitude = position.coords.longitude;

  //Creating a new object for using latitude and longitude values with Google map.
  var latLng = new google.maps.LatLng(latitude, longitude);


  showMap(latLng);

  addNearByPlaces(latLng);
  createMarker(latLng);
  
  //Also setting the latitude and longitude values in another div.
 // var div = document.getElementById("location");
  //div.innerHTML = "You are at Latitude: " + latitude + ", Longitude: " + longitude;
}

function showMap(latLng) {
  geocoder = new google.maps.Geocoder();

var markers = [];
  //Setting up the map options like zoom level, map type.
  var mapOptions = {
    center: latLng,
    zoom: 15,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };

  //Creating the Map instance and assigning the HTML div element to render it in.
  map = new google.maps.Map(document.getElementById("googlemap"), mapOptions);
  // Create the search box and link it to the UI element.
  
}

function addNearByPlaces(latLng) {

  var nearByService = new google.maps.places.PlacesService(map);
  
  
  var request = {
    location: latLng,
    radius: 500,
    types: ['atm']
  };

  nearByService.nearbySearch(request, handleNearBySearchResults);
}

function handleNearBySearchResults(results, status) {
  if (status == google.maps.places.PlacesServiceStatus.OK) {
    for (var i = 0; i < results.length; i++) {
      var place = results[i];
      createMarker(place.geometry.location, place);
    }
  }
}

function createMarker(latLng, placeResult) {
  var markerOptions = {
    position: latLng,
    map: map,
    animation: google.maps.Animation.DROP,
    clickable: true
  }
  //Setting up the marker object to mark the location on the map canvas.
  var marker = new google.maps.Marker(markerOptions);

  if (placeResult) {
    var content = "<b>Name : </b>"+placeResult.name+"<br/><b>Address : </b>"+placeResult.vicinity+"<br/><b>Type :  </b>"+placeResult.types+"<br/> Rating : "+placeResult.rating+'<br/>' ;
    addInfoWindow(marker, latLng, content);
  }
  else {
    var content = "You are here: ";
    addInfoWindow(marker, latLng, content);
  }

}

function codeAddress() {
  var address = document.getElementById('address').value;
  geocoder.geocode( { 'address': address}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      map.setCenter(results[0].geometry.location);
	  
          var latitude = results[0].geometry.location.lat();
          var longitude = results[0].geometry.location.lng();
        <!-- alert("Latitude: " + latitude + "\nLongitude: " + longitude); -->
      var marker = new google.maps.Marker({
          map: map,
          position: results[0].geometry.location
      });
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  

	    var latLngs = new google.maps.LatLng(latitude, longitude);

  addNearByPlaces(latLngs);
  createMarker(latLngs);
  
  });
  
}


function addInfoWindow(marker, latLng, content) {
  var infoWindowOptions = {
    content: content,
    position: latLng
  };

  var infoWindow = new google.maps.InfoWindow(infoWindowOptions);
 

  google.maps.event.addListener(marker, "click", function() {
			for(var i=0;i<marker.length;i++){
				infoWindow.close();
			}
			infoWindow.open(map);
			
  });
  
  
}
</script>
<style>
      #target {
        width: 345px;
      }
    </style>

<%@ include file="/WEB-INF/pages/header.jsp"%>

  <div id="mideal">
    	<div id="mapbox">
         	<div id="mapasearch">
            	<div id="searchayea"><input type="text"  id="address" name="" placeholder="Enter City Nmae And Postal Code"  style="width:270px; height:20px; "/><img onClick="codeAddress()" src="<c:url value='/images/search.png'/>" /></div>
                <div id="distence">
                	<span>Distance &nbsp; ( in km)&nbsp;</span>
                    <select style="width:50px;">
                    	<option value="1">1</option>
                        <option value="1">2</option>
                        <option value="1">3</option>
                        <option value="1">4</option>
                        <option value="1">5</option>
                        <option value="1">6</option>
                        <option value="1">7</option>
                        <option value="1">8</option>
                        <option value="1">9</option>
                        <option value="1">10</option>
                    </select>
                </div>
                <div id="advancesearch"><input type="button" value="Advance Search" onClick="codeAddress()" name=""  id="serchbu"/></div>
            </div>
            <div id="googlemap">google map loading</div>
        </div>
   
   <%@ include file="/WEB-INF/pages/footer.jsp"%>
