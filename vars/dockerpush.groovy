def call(String cred, String imageName, String tag){
  withCredentials([usernamePassword(
                    credentialsId: cred,
                    usernameVariable:"dockerUser",
                    passwordVariable:"dockerPass"
                    )]){
                        sh "echo $dockerPass | docker login -u $dockerUser --password-stdin"
                        sh "docker image tag $imageName:$tag $dockerUser/$imageName:$tag"
                        sh "docker push $dockerUser/$imageName:$tag"
                    }
}
