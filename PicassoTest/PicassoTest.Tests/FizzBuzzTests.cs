using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;

namespace PicassoTest.Tests
{
    class FizzBuzzTests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void NumberIsDivisibleBy3_NumberIs9_ReturnsFizz()
        {

            //Act
            var result = FizzBuzz.GetOutput(9);

            //Assert
            Assert.That(result, Is.EqualTo("Fizz"));

        }

        [Test]
        public void NumberIsDivisibleBy5_NumberIs10_ReturnsBuzz()
        {

            //Act
            var result = FizzBuzz.GetOutput(10);

            //Assert
            Assert.That(result, Is.EqualTo("Buzz"));

        }

        [Test]
        public void NumberIsDivisibleBy3And5_NumberIs15_ReturnsFizzBuzz()
        {

            //Act
            var result = FizzBuzz.GetOutput(15);

            //Assert
            Assert.That(result, Is.EqualTo("FizzBuzz"));

        }

        [Test]
        public void NumberIsNotDivisibleBy3And5_NumberIs4_ReturnsString4()
        {

            //Act
            var result = FizzBuzz.GetOutput(4);

            //Assert
            Assert.That(result, Is.EqualTo("4"));

        }

    }
}
