# PDF generation example

An example microservice that generates PDF documents.

## Purpose

Provides a microservice that uses measurable processing time and produces a binary response, for testing.

## Features

Generates a one-page PDF containing a blank page in a configurable RGB colour.

## Usage/examples

Send the following HTTP request, replacing the `:hex` URL path parameter with a CSS-style hexadecimal RGB colour code such as `ff0000` (red).

```
GET http://localhost:4567/colour/ff0000
```

From the command line, using cURL:

```
curl http://localhost:4567/colour/ff0000 > ff0000.pdf
```

## Installation

1. Install a Java 8 runtime.
1. Install Apache Maven.
1. Download this repository.
1. Run `mvn compile exec:java`

## Asking questions

Message [@PeterHilton](https://twitter.com/peterhilton) on Twitter.

## Authors/maintainers

[Peter Hilton](https://github.com/hilton)
