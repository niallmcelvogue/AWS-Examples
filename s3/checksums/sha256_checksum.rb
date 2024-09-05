require 'digest'
require 'base64'

def calculate_sha256_base64(file_path)
  sha256 = Digest::SHA256.new
  File.open(file_path, 'rb') do |file|
    while chunk = file.read(8192)
      sha256.update(chunk)
    end
  end
  Base64.encode64(sha256.digest).strip
end

file_path = "myfile.txt"
sha256_base64 = calculate_sha256_base64(file_path)
puts "Base64-encoded SHA256 Checksum: #{sha256_base64}"