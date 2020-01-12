curl -X POST http://localhost:8080/v1/candidate \
	-H "Content-Type: application/json" \
	-d '{"candidateName":"Anna Smith","candidateOccupation":"Engineer","candidateLocation":"B", "candidateLevel":3, "candidateAppPosition":"Engineer"}' 
	
curl -X POST http://localhost:8080/v1/candidate \
	-H "Content-Type: application/json" \
	-d '{"candidateName":"John Doe","candidateOccupation":"Engineer","candidateLocation":"C", "candidateLevel":1, "candidateAppPosition":"Engineer"}'

curl -X POST http://localhost:8080/v1/candidate \
	-H "Content-Type: application/json" \
	-d '{"candidateName":"Mario Rossi","candidateOccupation":"Engineer","candidateLocation":"A", "candidateLevel":4, "candidateAppPosition":"Engineer"}'

curl -X POST http://localhost:8080/v1/candidate \
	-H "Content-Type: application/json" \
	-d '{"candidateName":"Pippo","candidateOccupation":"Design","candidateLocation":"a", "candidateLevel":1, "candidateAppPosition":"Engineer"}'

curl -X POST http://localhost:8080/v1/candidate \
	-H "Content-Type: application/json" \
	-d '{"candidateName":"Pluto","candidateOccupation":"Developer","candidateLocation":"d", "candidateLevel":5, "candidateAppPosition":"Engineer"}'
	
curl -X POST http://localhost:8080/v1/candidate \
	-H "Content-Type: application/json" \
	-d '{"candidateName":"Richard Smith","candidateOccupation":"Developer","candidateLocation":"A", "candidateLevel":4, "candidateAppPosition":"Engineer"}'
	
curl -X POST http://localhost:8080/v1/candidate \
	-H "Content-Type: application/json" \
	-d '{"candidateName":"Jean Someres","candidateOccupation":"Developer","candidateLocation":"d", "candidateLevel":1, "candidateAppPosition":"Engineer"}'

curl -X POST http://localhost:8080/v1/candidate \
	-H "Content-Type: application/json" \
	-d '{"candidateName":"Mary Simpson","candidateOccupation":"Developer","candidateLocation":"b", "candidateLevel":5, "candidateAppPosition":"Engineer"}'
	
curl -X POST http://localhost:8080/v1/vacancy \
	-H "Content-Type: application/json" \
	-d '{"jobCompany": "Google", "jobTitle": "Engineer", "jobDescription": "Senior Software Engineer","jobLocation": "G","jobLevel": 5}'

