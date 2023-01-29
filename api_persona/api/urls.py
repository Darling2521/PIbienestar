from rest_framework.routers import DefaultRouter
from api.views import PacienteViewSet, EspecialistaViewSet, TipoPersonaViewSet

router = DefaultRouter()

router.register('api/paciente', PacienteViewSet)
router.register('api/especialista', EspecialistaViewSet)

urlpatterns = []

urlpatterns += router.urls
