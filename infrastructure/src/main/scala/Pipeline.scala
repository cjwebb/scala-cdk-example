import software.amazon.awscdk.core._
import software.amazon.awscdk.pipelines._

import java.util.Arrays.asList

object ProjectApp {
  def main(args: Array[String]): Unit = {
    val app = new App()

    new PipelineStack(app, "PipelineStack", StackProps.builder().env(
      Environment.builder().region("eu-west-2").build()
    ).build())

    app.synth()
  }
}

class PipelineStack(scope: Construct, id: String, stackProps: StackProps) extends Stack(scope, id, stackProps) {

  private val source = CodePipelineSource.gitHub("cjwebb/scala-cdk-example", "master")

  CodePipeline.Builder.create(this, "pipeline")
    .pipelineName("Pipeline")
    .synth(
      ShellStep.Builder.create("synth")
        .input(source)
        .commands(asList(
          "npm install -g aws-cdk", "cdk synth"
        )).build(),
    )
    .build()
}
