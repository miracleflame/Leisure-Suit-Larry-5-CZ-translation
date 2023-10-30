;;; Sierra Script 1.0 - (do not remove this comment)
(script# 480)
(include sci.sh)
(use Main)
(use LLRoom)
(use n940)
(use n958)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm480 0
)

(local
	local0
	[local1 29] = [0 273 274 275 297 467 387 147 161 291 861 911 146 892 752 753 754 755 756 751 526 851 482 483 484]
	local30
)
(procedure (localproc_0a0f param1 param2 &tmp temp0 temp1)
	(global2 drawPic: 1 13)
	(= temp1
		(switch (Random 0 5)
			(0 global131)
			(1 gLowlightColor_5)
			(2 global138)
			(3 global142)
			(4 gLowlightColor)
			(else  global146)
		)
	)
	(Display
		param1
		dsCOLOR
		temp1
		dsCOORD
		1
		(- 89 (/ (* 12 param2) 2))
		dsWIDTH
		318
		dsFONT
		global26
		dsALIGN
		1
	)
)

(instance rm480 of LLRoom
	(properties
		picture 480
		style $0007
	)
	
	(method (init)
		(proc958_0 129 1)
		(proc958_0 135 global174)
		(proc958_0 132 100)
		(copter init: setCycle: Fwd)
		(super init:)
		(if (proc0_6 47)
			(gLongSong
				number: 462
				flags: 1
				setLoop: -1
				setVol: 127
				play:
			)
		)
		(gLongSong2
			number: 468
			flags: 1
			setLoop: -1
			setVol: 127
			play:
		)
		(self setScript: sCartoon)
	)
	
	(method (dispose)
		(super dispose: &rest)
		(gLongSong fade: 0 15 12 1)
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= seconds 3))
			(1
				(proc0_18 gLarry 480 0 108 self 67 -1 20)
			)
			(2
				(proc0_14 480 1 80 {Larry} 108 self 67 -1 20)
			)
			(3
				(proc0_18 gLarry 480 2 108 self 67 -1 20)
			)
			(4
				(proc0_14 480 3 80 {Viprezident} 108 self 67 -1 20)
			)
			(5
				(proc0_14 480 4 80 {Larry} 108 self 67 -1 20)
			)
			(6
				(proc0_18 gLarry 480 5 108 self 67 -1 20)
			)
			(7
				(copter setLoop: 0 setCycle: End self)
			)
			(8
				(copter
					cycleSpeed: 8
					setLoop: 1
					setCel: 0
					cycleSpeed: 8
					moveSpeed: 8
					setCycle: End self
					setMotion: MoveTo 165 128
				)
			)
			(9
				(copter
					x: 285
					y: 79
					xStep: 7
					yStep: 7
					setLoop: 2
					setCel: 0
					cycleSpeed: 6
					moveSpeed: 6
					setCycle: Fwd
					setMotion: MoveTo 350 61 self
				)
				(gLongSong2 fade:)
			)
			(10 (= ticks 120))
			(11
				(gLongSong fade: 0 15 12 1 self)
			)
			(12
				(gLongSong
					number: 100
					flags: 1
					setLoop: -1
					setVol: 127
					play:
				)
				(= ticks 120)
			)
			(13
				(proc0_14 480 6 67 -1 20)
				(proc0_14 480 7)
				(= seconds 3)
			)
			(14
				(proc0_14 480 8 67 -1 15 70 280)
				(proc0_14 480 9)
				(= seconds 3)
			)
			(15
				(proc0_14 480 10 67 -1 15 70 280)
				(proc0_14 480 11)
				(= seconds 3)
			)
			(16
				(proc0_14 480 12 67 -1 15 70 280)
				(proc0_14 480 13)
				(= seconds 3)
			)
			(17
				(proc0_14 480 14 67 -1 15 70 280)
				(proc0_14 480 15)
				(= seconds 3)
			)
			(18
				(proc0_14 480 16 67 -1 15 70 280)
				(proc0_14 480 17)
				(= seconds 3)
			)
			(19
				(proc0_14 480 18 67 -1 15 70 280)
				(proc0_14 480 19)
				(= seconds 3)
			)
			(20
				(proc0_14 480 20 67 -1 15 70 280)
				(= seconds 3)
			)
			(21
				(proc0_14 480 21)
				(= seconds 3)
			)
			(22
				(proc0_14 480 22 67 -1 185)
				(= seconds 3)
			)
			(23
				(localproc_0a0f {Manaûer v˝tvarnÈho t˝mu\n\nCheryl Loyd} 3)
				(= seconds 3)
			)
			(24
				(global2 drawPic: 1 13)
				(= local30
					(switch (Random 0 5)
						(0 global131)
						(1 gLowlightColor_5)
						(2 global138)
						(3 global142)
						(4 gLowlightColor)
						(else  global146)
					)
				)
				(Display
					{Anim·to¯i\n\n}
					dsCOLOR
					local30
					dsCOORD
					1
					35
					dsWIDTH
					318
					dsFONT
					global26
					dsALIGN
					1
				)
				(Display
					{\n\nCheryl Loyd\nBarry T. Smith\nRoger Hardy Jr.\nDana M. Dean\nKarin Young\nMarc Hudgins\nEric Kasner}
					dsCOLOR
					local30
					dsCOORD
					1
					35
					dsWIDTH
					159
					dsFONT
					global26
					dsALIGN
					1
				)
				(Display
					{\n\nRichard Powell\nPhyllis Cucchiara\nTerry Falls\nMichael Hutchison\nDesie Hartman\nWillis Wong}
					dsCOLOR
					local30
					dsCOORD
					161
					35
					dsWIDTH
					159
					dsFONT
					global26
					dsALIGN
					1
				)
				(= seconds 8)
			)
			(25
				(localproc_0a0f
					{Grafika PozadÌ\n\nJane Cardinal\nMaurice Morgan\nAndy Hoyos\nCheryl Loyd\nJay Friedmann\nJennifer Shontz\nGloria Garland}
					9
				)
				(= seconds 5)
			)
			(26
				(localproc_0a0f
					{Program·to¯i\n\nBrian K. Hughes\nCarlos Escobar\nSteve Conrad\nJohn Hartin\nOliver Brelsford\nAl Lowe}
					8
				)
				(= seconds 5)
			)
			(27
				(localproc_0a0f {HudebnÌ reûisÈr\n\nMark Seibert} 3)
				(= seconds 3)
			)
			(28
				(global2 drawPic: 1 13)
				(= local30
					(switch (Random 0 5)
						(0 global131)
						(1 gLowlightColor_5)
						(2 global138)
						(3 global142)
						(4 gLowlightColor)
						(else  global146)
					)
				)
				(Display
					{Sierra's Creative Interpreter\nV˝vojov˝ systÈm\n\n}
					dsCOLOR
					local30
					dsCOORD
					1
					23
					dsWIDTH
					318
					dsFONT
					global26
					dsALIGN
					1
				)
				(Display
					{\n\n\nJeff Stephenson\nRobert E. Heitman\nDan Foy\nLarry Scott\nJohn Rettig\nJ. Mark Hood\nChris Smith\nTerry McHenry}
					dsCOLOR
					local30
					dsCOORD
					1
					23
					dsWIDTH
					159
					dsFONT
					global26
					dsALIGN
					1
				)
				(Display
					{\n\n\nEric Hart\nChad Bye\nMark Wilden\nKen Koch\nJohn Crane\nSteve Coallier\nRandy Moss}
					dsCOLOR
					local30
					dsCOORD
					161
					23
					dsWIDTH
					159
					dsFONT
					global26
					dsALIGN
					1
				)
				(= seconds 8)
			)
			(29
				(localproc_0a0f {DodateËn· hudba\n\nChris Braymen} 3)
				(= seconds 3)
			)
			(30
				(localproc_0a0f
					{DoplÚkov˝ pÌsemn˝ materi·l\n\nJosh Mandel}
					3
				)
				(= seconds 3)
			)
			(31
				(localproc_0a0f
					{VedoucÌ t˝mu pro zajiötÏnÌ kvality\n\nRobin Bradley}
					3
				)
				(= seconds 3)
			)
			(32
				(localproc_0a0f {Ml˝nek na k·vu\n\nC. Escobar} 3)
				(= ticks 100)
			)
			(33
				(if (DoSound sndSET_SOUND)
					(gLongSong2 number: 161 setLoop: 1 play:)
				)
				(= seconds 3)
			)
			(34
				(global2 drawPic: 1 13)
				(if (DoSound sndSET_SOUND)
					(proc0_14 480 23 80 {AL ¯Ìk·} 67 -1 20)
				)
				(= seconds 5)
			)
			(35 (gLongSong fade: self))
			(36
				(if (not (DoSound sndSET_SOUND))
					(= state (+ state 1))
				else
					(gGame setCursor: 999 1)
					(proc0_14
						480
						24
						80
						{Gratulujeme! Vyhr·li jste!!!}
						67
						-1
						15
						70
						280
					)
				)
				(= cycles 2)
			)
			(37
				(if
					(= local0
						(proc940_0
							{Nejste r·di, ûe jste si koupili p¯evodnÌk?}
							4
							50
							106
							81
							{Airport PA #1}
							1
							81
							{Airport PA #2}
							2
							81
							{Airport PA #3}
							3
							106
							81
							{Airport PA #4}
							4
							81
							{__AtmosfÈra__}
							5
							81
							{____K¯iËÌ____}
							6
							106
							81
							{______Yeow______}
							7
							81
							{_____K·va_____}
							8
							81
							{Skl·dacÌ ûidle}
							9
							106
							81
							{VlËÌ pÌöùalka_}
							10
							81
							{___Klep·nÌ___}
							11
							81
							{___Sklenice #1___}
							12
							106
							81
							{___Sklenice #2___}
							13
							81
							{_______Ah_______}
							14
							81
							{_______Oh_______}
							15
							106
							81
							{_______AH!_______}
							16
							81
							{______OH!______}
							17
							81
							{_____Oooh!_____}
							18
							106
							81
							{ DavovÈ dechy_}
							19
							81
							{ ämejdi jedÌ_}
							20
							81
							{_____Splach_____}
							21
							106
							81
							{_____ÿ˝ch_____}
							22
							81
							{_____Krk_____}
							23
							81
							{Nedot˝kat se}
							24
							106
							81
							{< Hotovo >}
							0
							4
							115
							80
							{DÌky za koupi "Larryho 5!"}
							121
							local0
						)
					)
					(gLongSong number: [local1 local0] setLoop: 1 play:)
					(self changeState: state)
				else
					(= cycles 1)
				)
			)
			(38
				(global2 drawPic: 1 13)
				(Display
					{NezapomeÚte na slogan Ala Lowa:}
					dsCOLOR
					gLowlightColor_6
					dsCOORD
					1
					30
					dsWIDTH
					318
					dsFONT
					global175
					dsALIGN
					1
				)
				(= cycles 2)
			)
			(39
				(if (DoSound sndSET_SOUND) (proc958_0 132 481))
				(= seconds 3)
			)
			(40
				(if (DoSound sndSET_SOUND)
					(gLongSong number: 481 setVol: 127 setLoop: 1 play:)
				)
				(Display
					{LepöÌ baby dÌky\ntechnologii!}
					dsCOLOR
					global131
					dsCOORD
					1
					90
					dsWIDTH
					318
					dsFONT
					global174
					dsALIGN
					1
				)
				(= seconds 5)
			)
			(41 (= global4 1))
		)
	)
)

(instance copter of Actor
	(properties
		x 160
		y 144
		view 480
		loop 3
	)
)
