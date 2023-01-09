package Systems;

import edu.wpi.first.math.geometry.Pose3d;
import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;

public class PhotonVisionController implements IVisionController{

    PhotonCamera camera = new PhotonCamera("camera1");


    @Override
    public Pose3d bestTargetPosition() {
        return null;
    }

    @Override
    public Pose3d[] allTargetPosition() {
        return new Pose3d[0];
    }

    @Override
    public void tellVisionToSwitchPipeline(int pipeline) {
        camera.setPipelineIndex(pipeline);
    }
}
