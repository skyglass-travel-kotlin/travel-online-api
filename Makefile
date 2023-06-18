start:
	docker-compose build
	docker-compose up

stop:
	docker-compose down

.PHONY: start stop 
