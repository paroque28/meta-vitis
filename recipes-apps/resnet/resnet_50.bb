DESCRIPTION = "This package contains Resnet50 program for DPU."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

COMPATIBLE_HOST = "aarch64.*-linux"

SRC_URI = "git://github.com/Xilinx/Vitis-AI.git;branch=v1.0"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"


do_install() {
  install -d ${D}/opt/Vitis-AI/img
  install -m 0644 ${S}/DPU-TRD/app/Vitis/samples/resnet50/img/greyfox-672194.JPEG ${D}/opt/Vitis-AI/img
  install -m 0644 ${S}/DPU-TRD/app/Vitis/samples/resnet50/img/bellpeppe-994958.JPEG ${D}/opt/Vitis-AI/img
  install -m 0644 ${S}/DPU-TRD/app/Vitis/samples/resnet50/img/irishterrier-696543.JPEG ${D}/opt/Vitis-AI/img
  install -m 0644 ${S}/DPU-TRD/app/Vitis/samples/resnet50/img/jinrikisha-911722.JPEG ${D}/opt/Vitis-AI/img

  install -d ${D}${bindir}
  install -m 0755 ${S}/DPU-TRD/app/Vitis/samples/resnet50/resnet50 ${D}${bindir}

  install -d ${D}${libdir}
  install -m 0655 ${S}/DPU-TRD/app/Vitis/models/libdpumodelresnet50.so ${D}${libdir}

  install -m 0755 -d ${D}/usr/lib
  install -m 0655 ${S}/DPU-TRD/app/Vitis/models/libdpumodelresnet50.so ${D}/usr/lib

}


FILES_${PN} += "/opt/ /opt/Vitis-AI/ /opt/Vitis-AI/* ${libdir} /usr/lib"

INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev += "dev-elf"
INSANE_SKIP_${PN}-libs = "dev-so"
INSANE_SKIP_${PN}-dbg = "dev-so"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

RDEPENDS_${PN} = "dnndk \
                  xrt \
				  libopencv-core \
                  libopencv-imgcodecs \
                  libopencv-highgui \
                  libopencv-imgproc \
" 
