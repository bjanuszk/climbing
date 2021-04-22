provider "local" {}
resource "local_file" "myFile" {
  content     = "New Content2"
  filename = "${path.module}/myfile.txt"
}
