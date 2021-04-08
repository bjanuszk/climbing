provider "local" {}
resource "local_file" "myFile" {
  content     = "ab"
  filename = "${path.module}/myfile.txt"
}
