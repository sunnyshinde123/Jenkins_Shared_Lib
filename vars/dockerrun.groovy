def call(String image, String tag, String ports){
  sh "docker run -d -p ${ports} ${image}:${tag}"
}
