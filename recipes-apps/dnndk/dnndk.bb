#
# This file is the dnndk recipe.
#

SUMMARY = "DNNDK Libraries"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

SRC_URI = "git://github.com/Xilinx/Vitis-AI.git;branch=v1.0 \
           file://dpu.xclbin \
           "

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"
RDEPENDS_${PN} += "xrt"

do_install() {
             install -m 0755 -d ${D}${libdir}
             install -m 0655 ${S}/DPU-TRD/app/Vitis/dnndk/libdpuaol.so ${D}${libdir}
             install -m 0655 ${S}/DPU-TRD/app/Vitis/dnndk/libhineon.so ${D}${libdir}
             install -m 0655 ${S}/DPU-TRD/app/Vitis/dnndk/libn2cube.so ${D}${libdir}
             install -m 0666 ${WORKDIR}/dpu.xclbin ${D}${libdir}

             install -m 0755 -d ${D}/usr/lib
             ln -s ../../../${libdir}/dpu.xclbin ${D}/usr/lib/dpu.xclbin
}

COMPATIBLE_HOST = "aarch64.*-linux"

INSANE_SKIP_${PN} = "ldflags"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

FILES_${PN} += "${libdir}/* /usr/lib"
