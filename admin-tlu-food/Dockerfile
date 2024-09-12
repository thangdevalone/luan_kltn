FROM node:18-alpine

# Build step
# 1. copy package.json and package-lock.json to /app dir
RUN mkdir /app
COPY package*.json /app
# 2. Change working directory to newly created app dir
WORKDIR /app
# 3 . Install dependencies
RUN npm install && yarn install
# 4. Copy the source code to /app dir
COPY . .
# 5. Expose port 3001 on the container
EXPOSE 3001
# 6. Run the app
CMD ["npm", "run", "dev"]