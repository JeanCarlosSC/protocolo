# Simulador de protocolo
📚 Una simulación de protocolo que permite la interacción de mensajes de control y de datos de acuerdo a unas reglas establecidas para la comunicación. (Asignatura: Redes de Comunicaciones I)

## Notas para el correcto funcionamiento
- Cada vez que el Transmisor envíe una trama, se deberá enviar la respuesta del receptor manualmente antes de enviar otra trama.
- El receptor sólo debe responder 1 vez manualmente por cada trama enviada por el transmisor. (para evitar mensajes duplicados en la secuencia de tramas)
- Los valores de respuesta se colocan automáticamente al recibir una trama, no es necesario modificarlo, podría cambiar el mensaje que le envía al sistema.

## Dudas
- Quita el header y el trailer y guarda la información para ser ensamblada cuando termine la transmisión.