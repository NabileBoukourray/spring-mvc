const path = require("path");
var ExtractTextPlugin = require('extract-text-webpack-plugin');

const config = {
    entry: {
        app: ["babel-polyfill",  "./resources/js/main.js", "./resources/css/main.scss" ],
    },
    output: {
        path: path.resolve(__dirname, "../src/main/webapp/resources/dist"),
        publicPath: "/dist/",
        filename: "bundle.js",
        publicPath: "/dist/"
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader"
                }
            },
            {
                test: /\.scss$/,
                exclude: /node_modules/,
                use: ExtractTextPlugin.extract([ "css-loader", "sass-loader"])
            },
            {
                test: /\.(woff(2)?|ttf|eot|svg)(\?v=\d+\.\d+\.\d+)?$/,
                use: [{
                    loader: 'file-loader',
                    options: {
                        name: '[name].[ext]',
                        outputPath: 'fonts/',
                        publicPath: '../dist/fonts/'
                    }
                }]
            },
            {
                test: /.*\.(gif|png|jpe?g)$/i,
                use: [
                    {
                        loader: 'file-loader',
                        options:{
                            outputPath: 'img/',
                            publicPath: '../dist/img/'
                        }
                    }
                ]
            }
        ]
    },
    plugins: [
        new ExtractTextPlugin({
            filename: "bundle.css",
            allChunks: true
        })
    ]
}
module.exports = config;