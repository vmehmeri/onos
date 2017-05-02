import requests
import json

url = 'http://192.168.137.100:8181/onos/v1/intents'
delete_url = 'http://192.168.137.100:8181/onos/v1/intents/org.onosproject.cli/'

headers = {'content-type': 'application/json'}




response = requests.get(url, headers=headers, auth=('onos', 'rocks'))
data = json.loads(response.text)['intents']

for d in data:
	requests.delete(delete_url+d['id'], headers=headers, auth=('onos', 'rocks'))


