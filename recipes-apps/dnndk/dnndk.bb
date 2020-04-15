#
# This file is the dnndk recipe.
#

SUMMARY = "DNNDK Libraries"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

SRC_URI = "git://github.com/Xilinx/Vitis-AI.git;branch=v1.0"
SRCREV = "${AUTOREV}"

inherit module-base

S = "${WORKDIR}/git"

DEPENDS += "opencv"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
	     install -d ${D}${libdir}
             install -m 0655 ${S}/DPU-TRD/app/Vitis/dnndk/libdpuaol.so ${D}${libdir}
             install -m 0655 ${S}/DPU-TRD/app/Vitis/dnndk/libhineon.so ${D}${libdir}
             install -m 0655 ${S}/DPU-TRD/app/Vitis/dnndk/libn2cube.so ${D}${libdir}
}

INSANE_SKIP_${PN} += "ldflags"
INSANE_SKIP_${PN} += "dev-so"

FILES_SOLIBSDEV = ""

FILES_${PN} += "${libdir}/* "
