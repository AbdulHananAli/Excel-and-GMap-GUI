package project_Nestle;

import java.io.IOException;
import java.net.URISyntaxException;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;
import netscape.javascript.JSObject;

public class GMap  implements MapComponentInitializedListener  {

	//used to setup the map
	GoogleMapView mapView;//contains the map
	MapOptions mapOptions;//used to customise GoogleMapsView 
	GoogleMap map;//contains the GoogleMapView
	Marker marker[];//location pin/s used to display a location
	MarkerOptions markerOptions[];//used to costumes the markers
	GMap_data source = new GMap_data();// used to get data for the Marker/s
	
	//used for click event
	private ObservableList<Table_data> All;//used to manipulate the items on the table (in the main GUI)
	Event event = new Event();//used to perform action after an event
	
	
	public StackPane getGMap() throws Exception {

	    //Create the JavaFX component and set this as a listener so we know when 
	    //the map has been initialised, at which point we can then begin manipulating it.
	    mapView = new GoogleMapView();//creates a map
	    //set specks
	    mapView.maxHeight(500);
	    mapView.maxWidth(500);
	    
	    mapView.addMapInializedListener(this);//adds properties by utilising the mapInitialized methods
	    
	    StackPane layout = new StackPane(mapView);//adds map to layout
	    layout.setMaxSize(500, 500);//set size so its viewable
		return layout;//returns the layout with the map
	}

	public void mapInitialized() {
	    //Set the initial properties of the map.
	    //MapOptions 
		mapOptions = new MapOptions();//Initialise map
	   //set options
		mapOptions.center(new LatLong(30.375321, 69.345116))//Centre point of the map
	            //.mapType(MapType.ROADMAP)
	            .overviewMapControl(false)
	            .panControl(false)
	            .rotateControl(false)
	            .scaleControl(false)
	            .streetViewControl(false)
	            .zoomControl(true)//enable zoom
	            .zoom(7);//Default zoom level
	    map = mapView.createMap(mapOptions, false);//set map with options and links to markers
	    
	    //create arrays to hold the information from GMap_data
	    String Name[]=null;
		double Lat[]=null;
		double Long[]=null;
	    
		
	    try {
			//use GMap_data (source) to populate the array
	    	Name = source.getTitle();
			Lat  = source.getLat();
			Long = source.getLong();
		} catch (IOException | URISyntaxException e) {
			//if fail don't do anything
		}//try/catch
	    
	    //set a marker/Options for each Name (units of data from the GMap_data)
	    //Marker marker[];
	    marker = new Marker[Name.length];
	    //MarkerOptions markerOptions[];
	    markerOptions = new MarkerOptions[Name.length];
	    
	    //loop through each marker and give properties
	    for(int x=0;x <= Name.length-1; x++ ){
			
	    	//setup and add marker/Options
		    markerOptions[x] = new MarkerOptions();//initalise the MarkerOptions
		    markerOptions[x].position( new LatLong(Lat[x], Long[x]))//set location
		                .visible(Boolean.TRUE);//make it visible
		   marker[x] = new Marker( markerOptions[x] );//initalise the Marker
		   marker[x].setTitle(Name[x]);//set name
		   int a = x;//to use for the EventHadler (some reason refuses to take "x" as a variable)
		   //add an event handler to the marker 
		   map.addUIEventHandler(marker[x], UIEventType.click, (JSObject obj) -> { try {
			  //take the marker name and use it as a key to search the main excel-sheet
			   All = event.eventSearch(marker[a].getTitle(), 3);} catch (IOException | URISyntaxException e) {
			} });
		   //add marker to map
		   map.addMarker(marker[x]);
		}
	}
	
	public ObservableList<Table_data> getMapIT(){
		//if a user has click a marker the list should be populated and the method returns the table object linked to the marker 
		return All;
	}
	
	public void ClearList(){
		//clears the list so it is not over populated
		All = null;
	}
}
