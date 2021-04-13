provider "local" {}
resource "local_file" "myFile" {
  content     = var.file_content
  filename = "${path.module}/${var.file_name}"
}
