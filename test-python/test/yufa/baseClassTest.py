class Animal(object):
      def run(self):
        print('Animal is running...')




class Dog(Animal):
    def run(self):
        print("dog is running...")

class Cat(Animal):
    def run(self):
        print("cat is running...")


dog=Dog()

dog.run()


cat = Cat()

cat.run()


print(type(dog))