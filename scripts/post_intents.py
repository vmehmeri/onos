import requests
import json

url = 'http://192.168.137.100:8181/onos/v1/intents'

headers = {'content-type': 'application/json'}


hosts=[]
hosts.append("00:00:00:00:00:01/-1")
hosts.append("00:00:00:00:00:02/-1")
hosts.append("00:00:00:00:00:03/-1")
hosts.append("00:00:00:00:00:04/-1")
hosts.append("00:00:00:00:00:05/-1")
hosts.append("00:00:00:00:00:06/-1")
hosts.append("00:00:00:00:00:07/-1")
hosts.append("00:00:00:00:00:08/-1")
hosts.append("00:00:00:00:00:09/-1")
hosts.append("00:00:00:00:00:0A/-1")
hosts.append("00:00:00:00:00:0B/-1")
hosts.append("00:00:00:00:00:0C/-1")
hosts.append("00:00:00:00:00:0D/-1")
hosts.append("00:00:00:00:00:0E/-1")
hosts.append("00:00:00:00:00:0F/-1")
hosts.append("00:00:00:00:00:10/-1")
hosts.append("00:00:00:00:00:11/-1")
hosts.append("00:00:00:00:00:12/-1")
hosts.append("00:00:00:00:00:13/-1")
hosts.append("00:00:00:00:00:14/-1")
hosts.append("00:00:00:00:00:15/-1")
hosts.append("00:00:00:00:00:16/-1")
hosts.append("00:00:00:00:00:17/-1")
hosts.append("00:00:00:00:00:18/-1")
hosts.append("00:00:00:00:00:19/-1")
hosts.append("00:00:00:00:00:1A/-1")
hosts.append("00:00:00:00:00:1B/-1")
hosts.append("00:00:00:00:00:1C/-1")
hosts.append("00:00:00:00:00:1D/-1")
hosts.append("00:00:00:00:00:1E/-1")
hosts.append("00:00:00:00:00:1F/-1")
hosts.append("00:00:00:00:00:20/-1")
hosts.append("00:00:00:00:00:21/-1")
hosts.append("00:00:00:00:00:22/-1")
hosts.append("00:00:00:00:00:23/-1")
hosts.append("00:00:00:00:00:24/-1")
hosts.append("00:00:00:00:00:25/-1")
hosts.append("00:00:00:00:00:26/-1")
hosts.append("00:00:00:00:00:27/-1")
hosts.append("00:00:00:00:00:28/-1")
hosts.append("00:00:00:00:00:29/-1")
hosts.append("00:00:00:00:00:2A/-1")
hosts.append("00:00:00:00:00:2B/-1")
hosts.append("00:00:00:00:00:2C/-1")
hosts.append("00:00:00:00:00:2D/-1")
hosts.append("00:00:00:00:00:2E/-1")
hosts.append("00:00:00:00:00:2F/-1")
hosts.append("00:00:00:00:00:30/-1")
hosts.append("00:00:00:00:00:31/-1")
hosts.append("00:00:00:00:00:32/-1")
hosts.append("00:00:00:00:00:33/-1")
hosts.append("00:00:00:00:00:34/-1")
hosts.append("00:00:00:00:00:35/-1")
hosts.append("00:00:00:00:00:36/-1")
hosts.append("00:00:00:00:00:37/-1")
hosts.append("00:00:00:00:00:38/-1")
hosts.append("00:00:00:00:00:39/-1")
hosts.append("00:00:00:00:00:3A/-1")
hosts.append("00:00:00:00:00:3B/-1")
hosts.append("00:00:00:00:00:3C/-1")
hosts.append("00:00:00:00:00:3D/-1")
hosts.append("00:00:00:00:00:3E/-1")
hosts.append("00:00:00:00:00:3F/-1")
hosts.append("00:00:00:00:00:40/-1")


payloads = [{}]

for index in range(0,len(hosts)/2):
	payloads.append( {"type": "HostToHostIntent",
	   "appId": "org.onosproject.cli",
  	   "priority": 55,
  	   "one": hosts[index],
  	   "two": hosts[len(hosts)-index-1]} )	
	
for payload in payloads:
	response = requests.post(url, data=json.dumps(payload), headers=headers, auth=('onos', 'rocks'))
	print response
	#print payload





