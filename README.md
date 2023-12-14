<h1 align="center"> Автоматизация API: REST Assured + Java, проект с Google API </h1>



## Summary:

- 1.Проверить правильно ли подтягивается инфа с ВЕБ'а.
- 2.Использование логирования и других методов.
- 3.Сделать assertions используя класс Matchers.
- 4.Извлекаем данные методом extract.

## I've applied:

- Rest Assured, TestNG
- site - https://swapi.dev/ , https://jsonplaceholder.typicode.com/
- split into Config and Constants
- RequestSpecification / ResponseSprecification
- class Matchers for assertions
- method Extract to recieve data from requests

## Process creating:

- 1.В классе TestConfig - метод BeforeClass - сетапим URL, PATH.
- 2.В классе Constants - создаем классы в которых переменные будут и значения (endpoint, path, url).
- 3.В классе ApiTest - тесты на валидацию данных, assertions, извлекаем данные из запросов.
- 4.В классе JsonPlaceHolderTest - используем (GET, PUT, POST, DELETE) + queryParams method.

## Additional:

- My profile on GitHub - [тыць](https://github.com/nick8787)
- My tg - [тыць](https://t.me/nick8787)
- My website about testing - [тыць](https://www.testing87.online/)
