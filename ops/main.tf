provider "local" {}
resource "local_file" "myFile" {
  content     = "New Content3"
  filename = "${path.module}/myfile.txt"
}
