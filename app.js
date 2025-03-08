const http = require('http');
const fs = require('fs');
const url = require('url');
const queryString = require('querystring');

const hostname = 'localhost';
const port = 3000;

let data = [];

const server = http.createServer((req, res) => {
    const parseurl = url.parse(req.url);
    const path = parseurl.pathname;

    if (path === '/' && req.method === "GET") {
        fs.readFile('index.html', (err, content) => {
            if (err) {
                res.writeHead(500, { 'Content-Type': 'text/plain' });
                res.end('read file error');
            } else {
                res.writeHead(200, { 'Content-Type': 'text/html' });
                res.end(content);
            }
        });
    } else if (path === '/submit' && req.method === 'POST') {
        let body = '';
        req.on('data', (chunk) => {
            body += chunk.toString();
        });
        req.on("end", () => {
            const parseBody = queryString.parse(body);
            if (!parseBody.name || !parseBody.message) {
                console.error("Missing name or age in the request body!");
            } else {
                data.push({ name: parseBody.name, message: parseBody.message });
            }

            res.writeHead(302, { Location: "/" });
            res.end();
        });
    } else if (path === '/data' && req.method === 'GET') {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify(data));
    } else {
        res.writeHead(404, { 'Content-Type': 'text/plain' });
        res.end('404 Not Found!')
    }
});

server.listen(port, hostname, () => {
    console.log(`http://${hostname}:${port}`);
})