FROM node:alpine

ENV INSTALL_PATH /var/www/app
RUN mkdir -p $INSTALL_PATH
WORKDIR $INSTALL_PATH

COPY package*.json ./
RUN npm install --quite
COPY . .

CMD ["npm", "run", "dev"]