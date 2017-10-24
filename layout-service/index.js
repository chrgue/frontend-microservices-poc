
'use strict';

const http = require('http');
const path = require('path');
const Tailor = require('node-tailor');
const customFilterRequestHeaders = require('./filterHeaders');
const fetchTemplateFs = require('node-tailor/lib/fetch-template');

const templatePath = path.join(__dirname, 'templates');
const baseTemplateFn = () => 'base-template';

const tailor = new Tailor({
    maxAssetLinks: 2,
    fetchTemplate: fetchTemplateFs(templatePath, baseTemplateFn),
    filterRequestHeaders: customFilterRequestHeaders
});

// Root Server
http
    .createServer((req, res) => {
        if (req.url === '/favicon.ico') {
            res.writeHead(200, { 'Content-Type': 'image/x-icon' });
            return res.end('');
        }
        tailor.requestHandler(req, res);
    })
    .listen(8090, function() {
        console.log('Tailor server listening on port 8090');
    });
