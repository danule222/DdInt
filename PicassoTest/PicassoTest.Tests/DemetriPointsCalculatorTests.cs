using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;

namespace PicassoTest.Tests
{
    class DemetriPointsCalculatorTests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void SpeedIsOutOfRange_Below0_ThrowsArgumentOutOfRangeException()
        {
            //Arrange
            var velocidad = new DemeritPointsCalculator();

            //Act
            Assert.Throws<ArgumentOutOfRangeException>(() => velocidad.CalculateDemeritPoints(-1));
            
        }

        [Test]
        public void SpeedIsOutOfRange_OverMaxSpeed_ThrowsArgumentOutOfRangeException()
        {
            //Arrange
            var velocidad = new DemeritPointsCalculator();

            //Act
            Assert.Throws<ArgumentOutOfRangeException>(() => velocidad.CalculateDemeritPoints(301));

        }

        [Test]
        public void SpeedIsOnRange_BelowMaxSpeed_Returns0()
        {
            //Arrange
            var velocidad = new DemeritPointsCalculator();

            //Act
            var result = velocidad.CalculateDemeritPoints(64);

            //Assert
            Assert.That(result, Is.EqualTo(0));

        }

        [Test]
        public void SpeedIsOnRange_OverMaxSpeed100_Returns7()
        {
            //Arrange
            var velocidad = new DemeritPointsCalculator();

            //Act
            var result = velocidad.CalculateDemeritPoints(100);

            //Assert
            Assert.That(result, Is.EqualTo(7));

        }

    }
}
