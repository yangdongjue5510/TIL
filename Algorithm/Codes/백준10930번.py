#using sha256 function in hashlib
#hashlib.sha256(byte object of String).hexdigest() = result of hash string
import hashlib

inputData = input()
encodedData = inputData.encode()
result = hashlib.sha256(encodedData).hexdigest()
print(result)