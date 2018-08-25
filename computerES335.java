/*A Computer Verison Of Electric Guitar ES 335
 * It can activate into Blues Sound or Heavy Metal Mode
 * It can also auto-tune the guitar into Standard Mode or Drop D Tuning
 * It can activate the pickups from single coil into humbucker
 * This project was inspired by the Robot Les Paul, which can tune
 * the guitar into standard mode by itself. 
@author Christian Gonzaga

*/

package edu.cuny.csi.csc330.lab3;
import java.util.Arrays;

public class computerES335 {

static int min = 0;
static int max = 9;
static int Default_Settings = 5;//for volume and knobs

	//Guitar Settings
private double neckVolume; 
private double bridgeVolume;
private double bridgeTone;
private double neckTone;
private String pickUpPosition;
private String bridgePickUpSettings;
private String neckPickUpSettings;
private String[] tuneSettings;

public void setNeckVolume(int newNeckVolume)
{
	neckVolume = newNeckVolume;
}

public void setBridgeVolume(int newBridgeVolume)
{
	bridgeVolume = newBridgeVolume;
}

public void setNeckTone(int newNeckTone)
{
	neckTone = newNeckTone;
}

public void setBridgeTone(int newBridgeTone)
{
	neckTone = newBridgeTone;
}

public double getNeckVolume()
{
	return neckVolume;
}

public double getbridgeVolume()
{
	return bridgeVolume;
}

public double getNeckTone()
{
	return neckTone;
}

public double getBridgeTone()
{
	return bridgeTone;
}

//Flips the switch to which pickups should activate
public void setPickupSettings(String newpickUpPosition)
{
	switch(newpickUpPosition)
	{
	case "Neck Pickups":
		newpickUpPosition = "neckPickups";
		pickUpPosition = newpickUpPosition;
		break;
	
	case "Both Pickups":
		 newpickUpPosition = "bothPickups";
		 pickUpPosition = newpickUpPosition;	 
		 break;
	case "Bridge Pickups":
		  newpickUpPosition = "bridgePickups";
		  pickUpPosition = newpickUpPosition;
		  break;
	
	};

}

//sets the bridge Pickup mode in either Single Coil or Humbucker
public void setBridgePickupMode( String newBridgePickUpMode)
{
	if(newBridgePickUpMode == "Single Coil")
	{ 
	  bridgePickUpSettings = "singleCoil";
	}
	else
	{
		bridgePickUpSettings = "humBucker";
	}
}

//sets the neckPickup in either single or humbucker
public void setNeckPickupMode( String setNeckPickupMode)
{	
	if( setNeckPickupMode == "Single Coil")
	{
	  neckPickUpSettings = "singleCoil";
	}
	else if( setNeckPickupMode == "Humbucker")
	{
		neckPickUpSettings = "humBucker";
		}
	
}

//Guitar Tune Settings
//Each element represents a string. 
public String[] standardTuning = { "e", "A", "D", "G", "B", "E"};
public String[] dropDTuning = {"D","A","D","G","B","E"};


//tunes the guitar into standard mode or dropD Mode
public void setTuneSettings(String newTuneMode)
{
	

	if( newTuneMode == "Standard Tuning")
	{
		tuneSettings = standardTuning;

	}
	else if(newTuneMode == "Drop D")
	{
		tuneSettings = dropDTuning;
	}
	
	
	
}

public String[] getTuneMode()
{
	return tuneSettings;
}

public void bluesSoundMode()
{
	setPickupSettings("Neck Pickups");
	neckVolume = max;
	neckTone = 7;
	bridgeVolume = Default_Settings;
	bridgeTone = Default_Settings;
	setBridgePickupMode("Single Coil");
	setNeckPickupMode("Single Coil");
	setTuneSettings("Standard Tuning");

}

public void heavyMetalmode()
{

	setPickupSettings("Bridge Pickups");
	neckVolume = 0;
	neckTone = 0;
	bridgeVolume = 7;
	bridgeTone =max;
	setBridgePickupMode("Humbucker");
	setNeckPickupMode("Humbucker");
	setTuneSettings("Drop D");
}	
public void defaultSettings()
{
	setPickupSettings("Both Pickups");
	neckVolume = Default_Settings;
	neckTone = Default_Settings;
	bridgeVolume = Default_Settings;
	bridgeTone = Default_Settings;
	setBridgePickupMode("Humbucker");
	setNeckPickupMode("Humbucker");
	setTuneSettings("Standard Tuning");
}

//default settings
//see if you can change the string and flip the switch 

//we use Arrays.toString to show what the elements are in the array.
//using +tunesettings+ instead of Arrays.toString(tune settings)
//will show errors. 
	
@Override
public String toString(){ 
	return "Guitar Instance:\n" +"Pickup Switch Settings = " +pickUpPosition+ 
			",Bridge Pickup sMode = " +bridgePickUpSettings+
			",Neck Pickup Settings = "+ neckPickUpSettings+ 
			"\nNeck Volume = " +neckVolume+
			",BridgeVolume = " +bridgeVolume+ " Neck Tone Level = " +neckTone+ 
			",Bridge Tone Level = " +bridgeTone+
			"\nTune Settings = " +Arrays.toString(tuneSettings)+
			"\n";							
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.out.println("Computer ES 335 Guitar Activated");
System.out.println("Guitar System Warming up....");
System.out.println("For Best Blues Performance,"
		+ "please turn on your Distortion Pedal and set tone to 2.0 Level");
System.out.println("For Best Heavy Metal Performance,"
		+ "please turn on your Distortion pedal and set tone to 7.0 Level \n");
//Initializing 
computerES335 ES335 = new computerES335(); 
//Heres I used the try and catch method to slowly load each output
//so I can give time for the computer ES 335 to change the settings.
try {
	Thread.sleep(1000);
	ES335.defaultSettings();
	System.out.println("Guitar Default Mode \n" +ES335+ "\n");
	Thread.sleep(1000);
	
	//sets into blues mode
	ES335.bluesSoundMode();
	System.out.println("Activate Gutiar Blues Mode In the Style Of B.B King\n" +ES335+ "\n");
	Thread.sleep(1000);
	Thread.sleep(1000);
	
	//sets into heavy metal mode
	ES335.heavyMetalmode();
	System.out.println("Activate Heavy Metal Mode In The Style of Black Sabbath\n" +ES335+ "\n");
	Thread.sleep(1000);
	Thread.sleep(1000);
	//Set the neckPickupMde from humbucker to singleCoil
	ES335.setNeckPickupMode("Single Coil");
	//Set back into Standard Tuning and changed the neck Volume
	ES335.setTuneSettings("Standard Tuning");
	ES335.setNeckVolume(6);
	System.out.println("Customization Mode: \n" +ES335+ "\n");
	
	
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}



	}
	
}