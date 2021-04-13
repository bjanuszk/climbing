provider "local" {}

module "file1" {
  source = "./modules/file"
  file_name = "f1.txt"
  file_content = "file 1 content"
}

module "file2" {
  source = "./modules/file"
  file_name = "f2.txt"
  file_content = "file 2 content"
}
