provider "local" {}
resource "local_file" "myFile" {
  content     = "This is new content"
  filename = "${path.module}/myfile.txt"
}
