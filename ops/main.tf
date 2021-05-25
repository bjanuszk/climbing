provider "local" {}
resource "local_file" "myFile" {
  content     = "New Content4"
  filename = "${path.xxxmodule}/myfile.txt"
}
