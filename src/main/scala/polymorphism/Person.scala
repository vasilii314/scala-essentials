package polymorphism

class Person {}

trait Parent {}

trait Female {}

class Mother extends Person with Parent with Female {}
