import java.io.File
import java.nio.file.Path

object IDEPathHelper {

  val gradleBinariesDirectory: Path = System.getProperty("java.class.path")
    .split(File.pathSeparator)
    .collectFirst { case cpe if cpe.endsWith("gatling") => Path.of(cpe) }
    .getOrElse(throw new IllegalStateException("Couldn't locate test-classes"))

  private val gradleBuildDirectory = gradleBinariesDirectory.getParent.getParent.getParent
  private val projectRootDir = gradleBuildDirectory.getParent
  private val gradleSrcDirectory = projectRootDir.resolve("src").resolve("gatling")

  val gradleSourcesDirectory: Path = gradleSrcDirectory.resolve("scala")
  val gradleResourcesDirectory: Path = gradleSrcDirectory.resolve("resources")
  val resultsDirectory: Path = gradleBuildDirectory.resolve("reports").resolve("gatling")
  val recorderConfigFile: Path = gradleResourcesDirectory.resolve("recorder.conf")
}
