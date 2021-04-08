provider "local" {}
resource "local_file" "myFile" {
  content     = "a"
  filename = "${path.module}/myfile.txt"
}
