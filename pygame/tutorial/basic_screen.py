import pygame
from pygame.locals import *
import sys

pygame.init()

DISPLAYSURF = pygame.display.set_mode((300,300))

BLACK = pygame.Color(0,0,0)
WHITE = pygame.Color(255, 255, 255)   # White
GREY = pygame.Color(128, 128, 128)   # Grey
RED = pygame.Color(255, 0, 0)       # Red

FPS = pygame.time.Clock()
FPS.tick(60)

while True:

    for event in pygame.event.get():
        if event.type == QUIT:
            pygame.quit()
            sys.exit()
    

    pygame.display.update()