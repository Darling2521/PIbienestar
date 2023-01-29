from rest_framework import serializers
from api.models import Paciente, Especialista

class EspecialistaSerializer (serializers.ModelSerializer):
    class Meta:
        model = Especialista
        fields = "__all__"
        
class PacienteSerializer (serializers.ModelSerializer):
    class Meta:
        model = Paciente
        fields = "__all__"
        
        