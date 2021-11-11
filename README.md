# Scala CDK Example

An example project that uses the AWS CDK, and SBT/Scala to create a self-updating CI pipeline.

We assume that you have installed the CDK properly, and you have an AWS account you can experiment in.

## Run

    npx cdk bootstrap
    npx cdk deploy

Then, make some changes, commit... and we see them being applied.

## Todo

- Need SBT on the Docker image used
- Switch Java version (as an example) ?
- sbt test & assembly -> then CodeArtifact
- Test reports
- Caching of libraryDependencies between runs.
