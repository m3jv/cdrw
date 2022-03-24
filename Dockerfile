
FROM alpine:3.14

CMD apk --no-cache add ca-certificates
    
WORKDIR /Users
