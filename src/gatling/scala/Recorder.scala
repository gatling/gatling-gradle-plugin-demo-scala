import io.gatling.recorder.GatlingRecorder
import io.gatling.recorder.config.RecorderPropertiesBuilder

object Recorder extends App {

  val props = new RecorderPropertiesBuilder()
    .simulationsFolder(IDEPathHelper.gradleSourcesDirectory.toString)
    .resourcesFolder(IDEPathHelper.gradleResourcesDirectory.toString)
    .simulationPackage("computerdatabase")
    .simulationFormatScala

  GatlingRecorder.fromMap(props.build, Some(IDEPathHelper.recorderConfigFile))
}
