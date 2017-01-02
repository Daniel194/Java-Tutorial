cmake_minimum_required(VERSION 3.6)
project(Operating_System)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES problema1.c)
add_executable(Operating_System ${SOURCE_FILES})