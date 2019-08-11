## Stage 1
#FROM node:10-alpine as node
#WORKDIR /usr/src/app
#COPY package*.json ./
#RUN npm install
#COPY . .
#RUN npm run build
#
## Stage 2
#FROM nginx:1.13.12-alpine
#COPY --from=node /usr/src/app/dist/search-client /usr/share/nginx/html
#COPY ./nginx.conf /etc/nginx/conf.d/default.conf

## base image
#FROM node:12.2.0
#
## install chrome for protractor tests
#RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
#RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
#RUN apt-get update && apt-get install -yq google-chrome-stable
#
## set working directory
#WORKDIR /app
#
## add `/app/node_modules/.bin` to $PATH
#ENV PATH /app/node_modules/.bin:$PATH
#
## install and cache app dependencies
#COPY package.json /app/package.json
#RUN npm install
#RUN npm install -g @angular/cli@7.3.9
#
## add app
#COPY . /app
#
## start app
#CMD ng serve --host 0.0.0.0

FROM nginx:alpine

COPY nginx.conf /etc/nginx/nginx.conf

WORKDIR /usr/share/nginx/html
COPY dist/ .
