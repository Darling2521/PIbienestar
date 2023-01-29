from django.db import models

    
class Especialista (models.Model):
    nombre = models.CharField(max_length=50)
    email = models.CharField(max_length=90)
    phone = models.CharField(max_length=90)
    estado = models.BooleanField(default=False)
    
class Paciente (models.Model):
    cedula = models.IntegerField()
    nombre = models.CharField(max_length=80)
    apellido = models.CharField(max_length=80)
    fecha_nacimiento = models.DateField(auto_now=False, auto_now_add=False)
    email = models.CharField(max_length=90)
    phone = models.CharField(max_length=90)
    

# Create your models here.
