provider "local" {}
resource "local_file" "myFile" {
  content     = "New Content"
  filename = "${path.module}/myfile.txt"
}
