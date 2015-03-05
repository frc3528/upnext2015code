package org.usfirst.frc.team3528.UpNext2015Robot.subsystems;

import org.usfirst.frc.team3528.UpNext2015Robot.commands.GetImages;
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 *
 */
public class Camera extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
    static int session;
    static Image frame;
    static USBCamera camera;
    
    public Camera() {
    	
    	//camera = new USBCamera("cam1");
    	//camera.setFPS(5);
    	
    	
	    frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		
	    // the camera name (ex "cam0") can be found through the roborio web interface
	    session = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	    NIVision.IMAQdxConfigureGrab(session);
    
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GetImages());
    }
    
    
    
    public void getImages() {
    	
        NIVision.IMAQdxGrab(session, frame, 1);        
        CameraServer.getInstance().setImage(frame);
    	
    }
}




