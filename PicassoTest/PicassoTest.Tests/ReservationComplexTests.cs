using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;

namespace PicassoTest.Tests
{
    class ReservationComplexTests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void CanBeCancelledBy_UserIsAdmin_ReturnsTrue()
        {
            //Arrange
            var reservation = new ReservationComplex();

            //Act
            var result = reservation.CanBeCancelledBy(new User()
            {
                IsAdmin = true
            });

            //Assert
            Assert.That(result, Is.True);
        }

        [Test]
        public void CanBeCancelledBy_UserIsMadeBy_ReturnsTrue()
        {
            //Arrange
            var paco = new User();
            var reservation = new ReservationComplex { MadeBy = paco };

            //Act
            var result = reservation.CanBeCancelledBy(paco);

            //Assert
            Assert.That(result, Is.True);
        }

        [Test]
        public void CanBeCancelledBy_UserIsNotMadeBy_ReturnsTrue()
        {
            //Arrange
            var paco = new User();
            var pepe = new User();
            var reservation = new ReservationComplex { MadeBy = paco };

            //Act
            var result = reservation.CanBeCancelledBy(pepe);

            //Assert
            Assert.That(result, Is.False);
        }

        [Test]
        public void CanBeCancelledBy_UserIsNull_ThrowsNullException()
        {
            //Arrange
            var paco = new User();
            var pepe = new User();
            var reservation = new ReservationComplex { MadeBy = paco };

            //Act
            Assert.Throws<NullReferenceException>(() => reservation.CanBeCancelledBy(null));
        }

        [Test]
        public void ReservationCanBePaid_UserIsNull_ThrowsNotImplementedException()
        {
            //Arrange
            var paco = new User();
            var pepe = new UserComplex();
            var reservation = new ReservationComplex { MadeBy = paco };

            //Act
            Assert.Throws<NotImplementedException>(() => reservation.PayReservation(null));
        }

        [Test]
        public void ReservationCanBePaid_UserComplex_ThrowsNotImplementedException()
        {
            //Arrange
            var paco = new User();
            var pepe = new UserComplex();
            var reservation = new ReservationComplex { MadeBy = paco };

            //Act
            Assert.Throws<NotImplementedException>(() => reservation.PayReservation(pepe));
        }

        /* No sabía si había que crear los tests suponiendo como funciona el método PayReservation,
         * a si que aquí los dejo por si acaso ( ˘ ³˘)
        [Test]
        public void ReservationCanBePaid_UserHasEnoughMoney_ReturnsTrue()
        {
            //Arrange
            var paco = new User();
            var pepe = new UserComplex { Money = 150 };
            var reservation = new ReservationComplex
            { 
                MadeBy = paco,
                Price = 100 
            };

            //Act
            var result = reservation.PayReservation(pepe);

            //Assert
            Assert.That(result, Is.True);
        }

        [Test]
        public void ReservationCanNotBePaid_UserHasNotEnoughMoney_ReturnsFalse()
        {
            //Arrange
            var paco = new User();
            var pepe = new UserComplex { Money = 78 };
            var reservation = new ReservationComplex
            {
                MadeBy = paco,
                Price = 100
            };

            //Act
            var result = reservation.PayReservation(pepe);

            //Assert
            Assert.That(result, Is.False);
        }

        [Test]
        public void ReservationCanNotBePaid_UserIsAdmin_ReturnsTrue()
        {
            //Arrange
            var paco = new User();
            var pepe = new UserComplex
            {
                Money = 78,
                IsAdmin = true
            };
            var reservation = new ReservationComplex
            {
                MadeBy = paco,
                Price = 100
            };

            //Act
            var result = reservation.PayReservation(pepe);

            //Assert
            Assert.That(result, Is.True);
        }
        */
    }
}
