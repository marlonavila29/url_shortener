# short-link-url2

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application

Installation and Execution
• Download the API source code.
• Open the terminal and navigate to the root directory of the project.
• Run the command in the terminal: ./mvnw quarkus:dev

Open PostMan and fill in as shown below:

<img width="1440" alt="Captura de Tela 2023-03-27 às 12 16 16" src="https://user-images.githubusercontent.com/12904290/227991565-80a28a75-a9bf-4444-b7e8-54585a981ad9.png">
using this endpoint: http://localhost:8080/url/shorten

and put some like this with JSON in the body:

```
"longUrl":"https://www.google.com/search?q=o+desejado+de+todas+as+na%C3%A7%C3%B5es+pdf&sxsrf=APwXEdetSOCh9D7i6HcXWHG5JdvQIRRTWg%3A1679930150688&ei=JrMhZN_MKazS1sQP19aGoAI&oq=O+desejado+de&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAxgAMgQIIxAnMgUILhCABDIHCAAQigUQQzIHCAAQigUQQzIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDoHCCMQsAMQJzoKCAAQRxDWBBCwAzoKCAAQigUQsAMQQzoHCC4QigUQQ0oECEEYAFCYA1j0A2DNDWgBcAF4AIABdIgBzQKSAQMwLjOYAQCgAQHIAQrAAQE&sclient=gws-wiz-serp"![image](https://user-images.githubusercontent.com/12904290/227992193-d485f57b-be10-4aa0-8c57-b960935e8c25.png)
```
The result will be some like this:
"http://localhost:8080/url/yOlgaoeE3v"

If you want open the long url, open new page in PostMan e put the short url as this way:
<img width="1440" alt="Captura de Tela 2023-03-27 às 12 17 06" src="https://user-images.githubusercontent.com/12904290/227992857-4a4e75b2-f8a2-44c0-bf5e-e0298541e1db.png">
So click SEND and you will be redirect to long url.
